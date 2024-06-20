package com.example.demo.Service.ServiceImpl;

import com.example.demo.Model.Roof;
import com.example.demo.Model.WoodenBeam;
import com.example.demo.Repository.WoodenBeamRepository;
import com.example.demo.Service.WoodenBeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class WoodenBeamServiceImpl implements WoodenBeamService {

    @Autowired
    private WoodenBeamRepository woodenBeamRepository;

    @Override
    public void proccesWoodenBeams(Roof roof, double upperLine) {
        Collection<WoodenBeam> woodenBeams = new ArrayList<WoodenBeam>();

        for (var i = 0; i < 3; i++) { // podroznice
            WoodenBeam wb = new WoodenBeam();
            wb.setForRoof(roof);
            wb.setWidth(15F);
            wb.setHeight(20F);
            wb.setLength(roof.getLengthPerSide() * 100);
            woodenBeams.add(wb);
        }

        for (var i = 0; i < 2 * roof.getLengthPerSide() + 4; i++) { // rogovi
            WoodenBeam wb = new WoodenBeam();
            wb.setForRoof(roof);
            wb.setWidth(10F);
            wb.setHeight(15F);
            wb.setLength((float) (upperLine * 100));
            woodenBeams.add(wb);
        }

        for (var i = 0; i < ((2 * roof.getLengthPerSide()) + (4 * upperLine)); i++) { // letve i kontraletve
            WoodenBeam wb = new WoodenBeam();
            wb.setForRoof(roof);
            wb.setWidth(5F);
            wb.setHeight(3F);
            wb.setLength((float) (upperLine * 100));
            woodenBeams.add(wb);
        }

        // Add all wooden beams to object
        for(var singleWb : woodenBeams){
            woodenBeamRepository.save(singleWb);
        }

    }
}
