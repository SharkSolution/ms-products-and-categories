package com.suresell.order;

import com.google.cloud.firestore.Firestore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductsApplicationTests {

	@Autowired
	private Firestore firestore;

	@Test
	void firestoreBeanShouldBeLoaded() {
		assertThat(firestore).isNotNull();
	}

}
