package com.nttdata.glue;

import com.nttdata.steps.OrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrderStepsDefs {

    @Steps
    OrderStep order;

    @Given("la url {string} del servicio")
    public void urlDelServicio(String url) {
        order.setUrlBase(url);
    }

    @When("creo la orden con orderId {int}, petId {int}, quantity {int}, shipDate {string} y status {string}")
    public void creoLaOrdenConPetIdPetIdQuantityQuantityShipDateYStatus(int orderId, int petId, int quantity, String shipDate, String status) {
        order.createOrder(orderId, petId, quantity, shipDate, status);
    }

    @Then("valido que el codigo de la respuesta sea {int}")
    public void validoQueElCodigoDeLaRespuestaSeaStatusCode(int statusCode) {
        order.velidateStatusCode(statusCode);
    }

    @And("valido que la respuesta devuelva orderId {int} petId {int}, quantity {int}, shipDate {string} y status {string}")
    public void validoQueLaRespuestaDevuelvaPetIdPetIdQuantityQuantityShipDateYStatus(int orderId, int petId, int quantity, String shipDate, String status) {
        order.validateResponseBody(orderId, petId, quantity, shipDate, status);
    }

    @When("consulto la orden con id {int}")
    public void consultoLaOrdenConIdOrderId(int orderId) {
        order.getOrder(orderId);
    }
}
