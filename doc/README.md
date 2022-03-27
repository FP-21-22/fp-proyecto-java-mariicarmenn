# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  21/22)
Autor/a: Carmen Capote Gómez   uvus:carcapgom

No se ha utilizado un dataset para la realización de la primera entrega del proyecto. 


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Dentro de esta carpeta podemos encontrar los siguientes paquetes

  * **fp.clinico**: Paquete que contiene los tipos Paciente, PacienteEstudio, Persona, Vacunacion y el enumerado TipoResidencia. 
  * **fp.farmaceutico**: Paquete que contiene el tipo Medicamento, el enumerado TipoMedicamento y la clase usada para parseo FactoriaMedicamentos.
  * **fp.farmaceutico.test**: Paquete que contiene la clase TestFactoriaMedicamentos, que se usa para comprobar el correcto funcionamiento de FactoriaMedicamentos
  * **fp.utiles**:  Paquete que contiene las clases de utilidad, Checkers usado para las excepciones y Validators usado para comprobar los digitos del dni del tipo Persona. 

## Tipos implementados

**Paciente**,**PacienteEstudio**,**Persona**,**Vacunacion**,**Medicamento**

### Tipo Persona


**Propiedades**:

- nombre, de tipo String, consultable. 
- apellidos, de tipo String, consultable. 
- dni, de tipo String, consultable.
- fechaNacimiento, de tipo LocalDate, consultable.
- edad, de tipo Integer, consultable. (derivada)

**Constructores**: 

- Método static of: recibe nombre, apellidos, dni y fecha de nacimiento y devuelve una persona.
- Método static parse: recibe una cadena con un formato específico y devuelve una persona.
- método main para comprobar el método parse.

**Restricciones**:
 
- R1: La fecha de nacimiento debe ser anterior a la fecha actual.
- R2: El dni debe ser una cadena con ocho dígitos y seguidos de una letra.

**Criterio de igualdad**: asocaido al record por defecto

**Criterio de ordenación**: según dni.


### Tipo Paciente


**Propiedades**:

- persona, de tipo Persona, consultable. 
- codigoDeIngreso, de tipo String, consultable. 
- fechaYHoraIngreso, de tipo LocalDateTime, consultable.
- fechaDeIngreso, de tipo LocalDate, consultable. (derivada)
- horaDeIngreso, de tipo LocalTime, consultable. (derivada)

**Constructores**: 

- Método static of: recibe nombre, apellidos, dni, fecha de nacimiento, código y fecha y hora de ingreso y devuelve un paciente.
- Método static of: recibe un objeto persona, un código y una fecha y hora de ingreso y devuelve


**Restricciones**:
 
- R1: La fecha y hora de ingreso debe ser anterior o igual a la fecha actual.

**Criterio de igualdad**: asociado al record por defecto.
**Criterio de ordenación**: asociado al record por defecto.


### Tipo PacienteEstudio


**Propiedades**:

- id, de tipo String, consultable. 
- genero, de tipo String, consultable. 
- edad, de tipo Double, consultable.
- hipertensión, de tipo Boolean, consultable.
- enfermedad del corazón, de tipo Boolean, consultable. 
- tipo de residencia, enumerado TipoResidencia, consultable.
- nivel medio de glucosa, de tipo Double, consultable.
- factor de riesgo, de tipo Boolean, consultable. (derivada)

**Constructores**: 

- Método static of: recibe valores para cada propiedad básica y devuelve un objeto del tipo.
- Método static parse: recibe una cadena con un formato especificado y y devuelve un objeto del tipo.
- método main para comprobar el método parse.


**Restricciones**:
 
- R1: La edad tiene que ser mayor o igual que cero y menor o igual que 130.
- R2: El nivel medio de glucosa tiene que ser mayor o igual que cero.

**Criterio de igualdad**: asocaido al record por defecto

**Criterio de ordenación**: según la edad y el id.


### Tipo Vacunacion


**Propiedades**:

- fecha, de tipo LocalDate, consultable. 
- comunidad, de tipo String, consultable. 
- pfizer, de tipo Integer, consultable.
- moderna, de tipo Integer, consultable.
- astrazeneca, de tipo Integer, consultable. 
- janssen de tipo Integer, consultable.
- número de personas, de tipo Integer, consultable.
- número total, de tipo Integer, consultable (derivada)

**Constructores**: 

- Método static of: recibe valores para cada propiedad básica y devuelve un objeto del tipo.
- Método static parse: recibe una cadena con un formato específico y devuelve un objeto del tipo. 
- método main para comprobar el método parse.

**Restricciones**:
 
- R1: La fecha de debe ser posterior al 01/02/2021.

**Criterio de igualdad**: asocaido al record por defecto

**Criterio de ordenación**: por comunidad y en caso de igualdad por fecha.


### Tipo Medicamento


**Propiedades**:

- nombre del medicamento, de tipo String, consultable. 
- tipo de medicamento, enumerado de tipo TipoMedicamento, observable.
- código de la enfermedad, de tipo String, observable.
- farmacéutica, de tipo String, observable.
- puntación, de tipo Double, observable.
- índice somático, de tipo Integer, observable.
- fecha de catálogo, de tipo LocalDate, observable y modificable.
- tratar enfermedad, de tipo Boolean. (derivada) 

**Constructores**: 

- C1: Recibe todas las propiedades básicas y devuelve un objeto del tipo Medicamento.


**Restricciones**:
 
- R1: La puntación tiene que ser mayor estricta que cero.
- R2: El índice somático tiene que ser mayor o igual que 1000.
- R3: La fecha de catálogo tiene que ser posterior al 01/01/2015.

**Criterio de igualdad**: por nombre del medicamento y farmacéutica.

**Criterio de ordenación**: por nombre del medicamento y en caso de igualdad por la farmacéutica.

**Clases auxiliares**
- FactoriaMedicamentos: incluye un método static parseaMedicamento que recib euna cadena con un formato espcífico y devuelve un objeto del tipo Medicamento.

-TestFactoriaMedicamentos: comprobar el correcto funcionamiento del método parseaMedicamentos.
