package com.john.specs;

class Person {
    private String nationality;
    private String name;
    private Integer age;

    Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    Person(String name, Integer age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Person)) {
            return false;
        }

        return String.valueOf(((Person) o).getName()).equals(String.valueOf(name));
    }
}
