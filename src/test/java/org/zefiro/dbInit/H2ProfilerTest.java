package org.zefiro.dbInit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.zefiro.dbInit.config.H2TestProfileJPAConfig;

class H2ProfilerTest {
	
	@ExtendWith(SpringExtension.class)
	@SpringBootTest(classes = {
	  DbInitApplication.class, 
	  H2TestProfileJPAConfig.class})
	@ActiveProfiles("test")
	public class SpringBootProfileIntegrationTest {
	    
		
	}

}
