Custom Generators
===================
Hibernate and JPA has provided predefined generatoers to create primary key values for almost all databases 
  eg: IDENTITY, INCREMENT, AUTO, SEQUENCE
  
  If we want Primary Key value to be generated for our columns as per our need then we need to go for Custom Generators.
  To create our own generator we need to implement interface called "IdentifierGenerator"
  It is a functional interface which only contains single method.
public serializable generate(SharedSessionContractImplementor session, Object obj) throws HBE.
