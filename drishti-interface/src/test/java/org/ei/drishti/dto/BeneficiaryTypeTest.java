package org.ei.drishti.dto;

import org.junit.Test;

public class BeneficiaryTypeTest {
	
	private BeneficiaryType beneficiaryType;
	
	@Test
	public void beneficiaryTypeTest(){
		assertThat(BeneficiaryType.child.value());
		assertThat(BeneficiaryType.mother.value());
		assertThat(BeneficiaryType.ec.value());
	}

	private void assertThat(String value) {
		// TODO Auto-generated method stub
		
	}

}
