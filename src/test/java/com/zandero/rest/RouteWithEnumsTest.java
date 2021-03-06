package com.zandero.rest;

import com.zandero.rest.test.TestEnumRest;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.codec.BodyCodec;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(VertxExtension.class)
public class RouteWithEnumsTest extends VertxTest {

    @BeforeAll
    static void start() {

        before();

        Router router = RestRouter.register(vertx, TestEnumRest.class);
        vertx.createHttpServer()
                .requestHandler(router)
                .listen(PORT);
    }

    @Test
    void valueOfTest(VertxTestContext context) {

        client.get(PORT, HOST, "/enum/simple/one").as(BodyCodec.string())
                .send(context.succeeding(response -> context.verify(() -> {
                    assertEquals("one", response.body());
                    assertEquals(200, response.statusCode());
                    context.completeNow();
                })));
    }

    @Test
    void fromStringTest(VertxTestContext context) {

        client.get(PORT, HOST, "/enum/fromString/3").as(BodyCodec.string())
                .send(context.succeeding(response -> context.verify(() -> {
                    assertEquals("three", response.body());
                    assertEquals(200, response.statusCode());
                    context.completeNow();
                })));
    }
}
