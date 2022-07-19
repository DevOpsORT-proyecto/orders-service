package uy.edu.ort.devops.ordersserviceexample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import uy.edu.ort.devops.ordersserviceexample.domain.OrderStatus;
import uy.edu.ort.devops.ordersserviceexample.dtos.PaymentStatus;
import uy.edu.ort.devops.ordersserviceexample.dtos.Product;
import uy.edu.ort.devops.ordersserviceexample.logic.OrdersLogic;

@SpringBootTest
class OrdersServiceExampleApplicationTests {

	OrderStatus orderStatus = new OrderStatus("1234", true, "Done.");
	PaymentStatus paymentStatus = new PaymentStatus("1234", true, "Done.");
	Product producto = new Product("123", "Producto 123", 10, "Este es un producto");
	OrdersLogic ordersLogic = new OrdersLogic();

	@Test
	void orderStatusTest() {
		assertEquals("Done.", orderStatus.getDescription());
		assertEquals("1234", orderStatus.getOrderId());
		assertEquals(true, orderStatus.isSuccess());
	}

	@Test
	void paymentStatusTest() {
		assertEquals("Done.", paymentStatus.getDescription());
		assertEquals("1234", paymentStatus.getOrderId());
		assertEquals(true, paymentStatus.isSuccess());
	}

	@Test
	void productTest() {
		assertEquals("Producto 123", producto.getName());
		assertEquals("123", producto.getId());
		assertEquals(10, producto.getStock());
		assertEquals("Este es un producto", producto.getDescription());
	}

}
