# Spring Boot — Lombok

## Lombok kya hai?

Lombok ek Java library hai jo **boilerplate code automatically generate** karti hai.

Boilerplate:
→ Getters
→ Setters
→ Constructors
→ toString()
→ equals()
→ hashCode()
→ etc.


## Common Lombok Annotations

@Getter
→ Getters generate


@Setter
→ Setters generate


@Data
→ Getter + Setter
→ toString()
→ equals()
→ hashCode()
→ RequiredArgsConstructor


@NoArgsConstructor
→ No-argument constructor


@AllArgsConstructor
→ All-fields constructor


@RequiredArgsConstructor
→ final / @NonNull fields ka constructor


@Builder
→ Builder pattern generate karta hai


@Slf4j
→ Logger automatically provide karta hai


## Example

Without Lombok:

public class Employee {

    private Long id;
    private String name;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


With Lombok:

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;
    private String name;
}


Bahut saara boilerplate code automatically generate ho gaya.


## @Builder Example

Employee employee = Employee.builder()
        .id(101L)
        .name("Jigar")
        .build();


## Spring Boot me Common Use

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private Long id;

    private String name;
}


## Important Interview Point

Lombok compile-time par code generate karta hai.

Matlab:

Lombok annotations
        ↓
Compile time
        ↓
Required methods/constructors generate


## @Data vs @Getter/@Setter

@Data
→ Bahut kuch automatically generate karta hai.

@Getter + @Setter
→ Sirf getters/setters chahiye to better control.


## Interview Answer

"Lombok is a Java library that reduces boilerplate code by generating common methods such as getters, setters, constructors, equals, hashCode and toString through annotations."


## Easy Memory

Lombok
→ Less Boilerplate Code

@Getter → Getter
@Setter → Setter
@Data → Common methods
@Builder → Builder
@NoArgsConstructor → Empty constructor
@AllArgsConstructor → All fields constructor
@Slf4j → Logger