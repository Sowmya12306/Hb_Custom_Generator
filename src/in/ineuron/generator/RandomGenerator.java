package in.ineuron.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomGenerator implements IdentifierGenerator{

	static {
		System.out.println("RandonGenerator.class file is started Loading");
	}
	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		System.out.println("RandonGenerator.generate()");
		String prefix = "MCA";
		Integer idValue = 0;
		idValue = new Random().nextInt(100000);
		String genId = prefix + idValue.toString();
		System.out.println("Generated id:: "+ genId);
		return genId;
	}
}
