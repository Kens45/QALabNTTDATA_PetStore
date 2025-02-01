package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;
import net.thucydides.core.annotations.Step;

public class OrderStep {

    private static String URL_BASE = null;

    public void setUrlBase(String urlBase) {
        URL_BASE = urlBase;
    }

    @Step("Crear order en PetStore")
    public void createOrder(int orderId, int petId, int quantity, String shipDate, String status) {
        System.out.println("Creando orden: "+orderId);
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .body("{\n" +
                        "  \"id\": \""+orderId+"\",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \""+ shipDate+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\": \""+true+"\"\n" +
                        "}")
                .log().all()
                .post("store/order")
                .then()
                .log().all()
        ;
    }

    @Step("Obtener order de PetStore")
    public void getOrder(int orderId) {
        System.out.println("Consultando orden: "+orderId);
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .log().all()
                .get("store/order/"+orderId)
                .then()
                .log().all()
        ;
    }

    @Step("Validar el codigo de la respuesta")
    public void velidateStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, SerenityRest.lastResponse().statusCode());
    }

    @Step("Validar el body de la respuesta")
    public void validateResponseBody(int orderId, int petId, int quantity, String shipDate, String status){
        System.out.println("########Validar BODY --------------");
        int idOrden = SerenityRest.lastResponse().getBody().path("id");
        int petIdOrden = SerenityRest.lastResponse().getBody().path("petId");
        int quantityOrden = SerenityRest.lastResponse().getBody().path("quantity");
        String shipDateOrden = SerenityRest.lastResponse().getBody().path("shipDate");
        String statusOrden = SerenityRest.lastResponse().getBody().path("status");
        System.out.println(orderId+" "+petId+" "+quantity+" "+shipDate+" "+status);
        System.out.println(idOrden+" "+petIdOrden+" "+quantityOrden+" "+shipDateOrden+" "+statusOrden);
        Assert.assertEquals(orderId, idOrden);
        Assert.assertEquals(petId, petIdOrden);
        Assert.assertEquals(quantity, quantityOrden);
        Assert.assertEquals(shipDate, shipDateOrden);
        Assert.assertEquals(status, statusOrden);
    }

}
