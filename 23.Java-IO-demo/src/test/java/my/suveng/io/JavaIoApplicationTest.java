package my.suveng.io;

import my.suveng.io.bio.file_io.FileIoDemo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 *
 * @author suwenguang
 **/
@SpringBootTest
public class JavaIoApplicationTest {

	@Autowired
	FileIoDemo fileIoDemo;

	@Test
	void fileIo() throws IOException {
		fileIoDemo.io();
	}

	@Test
	void load() {

	}
}
