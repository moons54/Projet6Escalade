package org.topo.projetp6.action;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

public class FileUploadAction extends ActionSupport {

    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;
 //   private GestionFichierProperties gfp = new GestionFichierProperties();


    public String getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(String fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public String getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(String fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }

    public File getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String execute() throws Exception{
        String nomImg="";
        System.out.println("val de "+fileUploadContentType);
        System.out.println("val de "+fileUpload);
        System.out.println("val de "+fileUploadFileName);
        Random r = new Random();
        int valeurMin=1;

        int valeurMax=100;
        int valeur = valeurMin + r.nextInt(valeurMax - valeurMin);


        System.out.println("val de int"+valeur);
        String renameph = "photo"+loginAction.session.get("nom").toString()+loginAction.session.get("experience")+valeur+loginAction.session.get("id")+".jpeg";
        fileUploadFileName = renameph;

        String filePath = getText("/Users/aurelienmimouni/wk1/TopoP6/topo-webapp/src/main/webapp/jsp/topo/images/");
        File fileToCreate = new File(filePath,fileUploadFileName);
        try {
            System.out.println("la "+fileToCreate.toString());
            FileUtils.copyFile(fileUpload, fileToCreate);
            //copying source file to new file

            loginAction.session.put("lienphoto","topo/images/"+renameph.toString());

        } catch (IOException e) {

            e.printStackTrace();
        }
        return SUCCESS;

    }

    public String display() {
        return NONE;
    }

}