package com.example.demo.Service.ServiceImpl;

import com.example.demo.Model.Building;
import com.example.demo.Model.Floor;
import com.example.demo.Model.Roof;
import com.example.demo.Repository.RoofRepository;
import com.example.demo.Service.RoofService;
import com.example.demo.Service.WoodenBeamService;
import com.example.demo.Utils.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoofServiceImpl implements RoofService {

    @Autowired
    private RoofRepository roofRepository;

    @Autowired
    private WoodenBeamService woodenBeamService;

    @Override
    public Roof processRoof(Building building) {
        Roof roof = building.getRoof();
        Floor firstFloor = building.getFloor().iterator().next();
        roof.setLengthPerSide((float) Math.sqrt(firstFloor.getSurfaceArea()));

        double upperLine = 2 * roof.getLengthPerSide() * Math.cos(Metrics.ROOF_PITCH_ANGLE);
        double boardingSurface = 4 * (upperLine * Metrics.ROOF_OVERHANG) + 2 * (roof.getLengthPerSide() * Metrics.ROOF_OVERHANG);
        double foilingSurface = ((upperLine + Metrics.ROOF_OVERHANG) * (roof.getLengthPerSide()) + Metrics.ROOF_OVERHANG) * 2;

        roof.setSurfaceAreaForBoarding((float) boardingSurface);
        roof.setSurfaceAreaForFoiling((float) foilingSurface);
        roof.setSurfaceAreaForDecking((float) (foilingSurface - boardingSurface));

        // Process wooden beams
        woodenBeamService.proccesWoodenBeams(roof, upperLine);

        return roofRepository.save(roof);
    }
}
