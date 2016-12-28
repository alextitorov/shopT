package controller;

import dto.BuyerDTO;
import model.enums.ImageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.BuyerService;
import service.ImageService;
import service.ImageServiceImpl;
import util.CurrentUser;
import util.PropertyApp;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ImageController {

    private ImageService imageService = new ImageServiceImpl();

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(value = "/avaForm", method = RequestMethod.GET)
    public String avaForm(){
        return "avaForm";
    }

    @RequestMapping(value = "/uploadAva", method = RequestMethod.POST)
    public String uploadAva(@RequestParam("avatar") MultipartFile avatar,
                            HttpServletRequest request){
        BuyerDTO buyer = buyerService.getByNameDTO(CurrentUser.getCurrentUserName());
        String uploadFolder = PropertyApp.PATH_AVATAR_UPLOAD + buyer.getId() + "/";
        String fileName = String.valueOf(ImageType.AVATAR).toLowerCase();
        imageService.save(avatar, uploadFolder, fileName);
        request.getSession().setAttribute("avatar", avatar.getOriginalFilename());
        request.getSession().setAttribute("buyerId", buyer.getId());
        return "avaForm";
    }

}
