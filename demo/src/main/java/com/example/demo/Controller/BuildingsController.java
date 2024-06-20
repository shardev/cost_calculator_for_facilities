package com.example.demo.Controller;

import com.example.demo.Model.Building;
import com.example.demo.Model.Wall;
import com.example.demo.Model.WallUnit;
import com.example.demo.Service.BuildingService;
import com.example.demo.Service.RoofService;
import com.example.demo.Service.WallService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileOutputStream;
import java.util.Collection;

@RestController
@RequestMapping("/buildings")
public class BuildingsController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private WallService wallService;

    @GetMapping(path = "/{buildingId}")
    ModelAndView getBuildingDetails(@PathVariable("buildingId") Integer buildingId){
        ModelAndView modelAndView = new ModelAndView("previewBuilding.html");
        Building building = buildingService.findById(buildingId);
        modelAndView.addObject("building", building);

        Collection<Wall> wallsForBuilding = buildingService.getWallsForBuilding(buildingId);
        modelAndView.addObject("wallsForBuilding", wallsForBuilding);
        modelAndView.addObject("wallUnit", wallService.findWallUnit(wallsForBuilding));

        modelAndView.addObject("roofUnit", building.getRoof().getRoofCoverUnit());
        modelAndView.addObject("carpentryUnitsForBuilding", buildingService.getCarpentryUnitsForBuilding(buildingId));

        modelAndView.addObject("floorsForBuilding", building.getFloor());
        return modelAndView;
    }

    @GetMapping(path = "/buildingsForOrderer")
    ModelAndView getBuildingDetails() {
        ModelAndView modelAndView = new ModelAndView("houses.html");
        modelAndView.addObject("houses", buildingService.findByOwner(1)); // spring security
        modelAndView.addObject("action", "preview");

        return modelAndView;
    }

    @RequestMapping(path="/generate")
    ModelAndView generatePdf(@RequestParam("bid") Integer bid){
        String out="";
        Building building = buildingService.findById(bid);
        out += building.toString();



        Collection<Wall> wallsForBuilding = buildingService.getWallsForBuilding(bid);
        for(var w: wallsForBuilding){
            out += w.toString();
        }

        WallUnit wu =  wallService.findWallUnit(wallsForBuilding);
        out += wu.toString();

        var carpentryUnitsForBuilding= buildingService.getCarpentryUnitsForBuilding(bid);
        for(var cu : carpentryUnitsForBuilding){
            out += cu.toString();
        }

        var floorsForBuilding = building.getFloor();
        for(var f: floorsForBuilding){
            out += f.toString();
        }

        // generate pdf and save
        try{
//            PdfWriter.getInstance(document, new FileOutputStream("overviewForbuilding.pdf"));
//            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//
//            document.open();
//            Chunk chunk = new Chunk(out, font);
//
//
//            document.add(chunk);
//
//            document.close();
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            //contentStream.setFont(PDType1Font.COURIER, 12);
            contentStream.beginText();
            contentStream.showText(out);
            contentStream.endText();
            contentStream.close();

            document.save("pdfBoxHelloWorld.pdf");
            document.close();

        }catch(Exception e){
            return getBuildingDetails(bid);
        }



        return getBuildingDetails(bid);
    }

}
