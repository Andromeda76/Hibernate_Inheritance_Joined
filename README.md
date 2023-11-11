# Hibernate_Inheritance_Per_Class
the difference between this strategy and @MappedSuperClass strategy is that in (Per_Class)
it is required to instantiate primary key in super annotated class but in @MappedSuperClass
it is not required to instantiate Id in super class;
The other one is that in @MappedSuperClass this class does not have any relationship with database directly
because of this we have to annotate repository belong to this class with @NoRepositoryBean to tell spring data 
that this repository doesnot have strait relationShip with database;
instead in @Table_Per_Class we do not have this limitation and when this strategy makes query with database 
it uses union for making query;
In both strategies there is no relationShip between tables and in the second one query will interpert to
Union All strategy in database;
