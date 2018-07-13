/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author abdalla
 */
@Path("/images")
public class ImagesResource {

    @GET
    @Path("/{imageName}")
    public Response renderImage(@PathParam("imageName") String imageName) {

        File imageFile = new File("images/" + imageName);
        if (!imageFile.exists()) {
            return Response.status(Status.NOT_FOUND)
                    .entity("Image not fouund")
                    .build();
        }

        int extIndex = imageFile.getName().lastIndexOf('.');
        String ext = imageFile.getName().substring(extIndex + 1).toLowerCase();

        try {
            String mime = getMimeType(ext);
            return Response.ok(new FileInputStream(imageFile), mime).build();
        } catch (IllegalArgumentException ex) {
            return Response.status(Status.NOT_FOUND)
                    .entity("Unknown image type!").build();
        } catch (IOException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("I/O error occured!").build();
        }
    }

    private String getMimeType(String ext) {
        if ("jpg".equals(ext)) {
            return "image/jpg";
        } else if ("png".equals(ext)) {
            return "image/png";
        } else if ("gif".equals(ext)) {
            return "image/gif";
        } else {
            throw new IllegalArgumentException("Unkown exception!");
        }
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadImage(
            @FormDataParam("imageFile") InputStream imageFileStream,
            @FormDataParam("imageFile") FormDataContentDisposition fileDisposition) {
        File imageFile = new File("/home/abdalla/Desktop/images/" + fileDisposition.getFileName());
        if (imageFile.exists()) {
            return Response.status(Status.NOT_FOUND)
                    .entity("Image with the same name already exists!")
                    .build();
        }

        try {
            FileOutputStream fos = new FileOutputStream(imageFile);
            byte[] buff = new byte[5 * 1024];
            int len;
            while ((len = imageFileStream.read(buff)) != -1) {
                fos.write(buff, 0, len);
            }
            fos.close();
            return Response.ok("Image uploaded successfully!").build();
        } catch (IOException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("I/O error occured!").build();
        }
    }
}
