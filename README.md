# vaccination
simple App de control de vacunas de los empleados de una empresa
# Instalacion

1) Crear las bases de datos, tanto del entorno real como el de test, la del entorno real debe ser vaccination y la de test vaccinationtest

2) Cambiar las credenciales de base de datos en los archivos de configurarion encontrados en /src/main/resources/application.properties (base de datos real) y /src/test/resources/application.properties (basde de datos de test)

3) En el archivo /src/main/java/com/challenge/vaccination/VaccinationApplication.java se encuentra un metodo que comienza con la notacion @Bean que crea un usuario admin por defecto, sus credenciales son username admin y password root
