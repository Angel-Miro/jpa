# JPA [proyecto y documentación]


## FetchType: Existen 2 tipos: Es el tipo de carga 
![FetchType.png](src/main/resources/images/FetchType.png)


-   **FetchType.EAGER (carga ansiosa)**: Quiere decir que cuando se busque el Departamento, cargará al mismo tiempo  los empleados. La relación @OneToOne y @ManyToOne por defecto utilizan este tipo de FetchType.

-   **FetchType.LAZY (carga perezosa)**: Es lo contrario al EAGER, quiere decir que cuando se cargue la entidad Departamento no se cargarán sus empleados. Y para poder cargar sus empleados se tendrá que hacer una consulta que haga join con los empleados findByDepartamentAndEmployees, las anotaciones @ManyToMany y @OneToMany por defecto usan ese FetchType. 

## CascadeType: Forma en la que se propagan las entidades(entidades relacionadas entre si)
![CascadeType.png](src/main/resources/images/CascadeType.png)

- **PERSIST:** Cuando se persiste la entidad principal también se persisten las relacionadas
- **MERGE:** Fusionar los cambios de la entidad principal también se fusionan los cambios en las entidades relacionadas
- **REMOVE:** Eliminando la entidad principal se eliminan las entidades relacionadas
- **REFRESH:** Se actualiza una vez que note una actualización
- **DETACH:** Se quita la relación de una entidad relacionada con la principal
- **ALL:** Engloba todas las anteriores


## Orphan Removal: Se quedan sin relación con la entidad principal
![OrphanRemoval.png](src/main/resources/images/OrphanRemoval.png)

### Relaciones @OneToMany y @OneToOne