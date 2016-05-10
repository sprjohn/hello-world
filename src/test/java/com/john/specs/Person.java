package com.john.specs;

class Person {
    private String name;
    private Integer age;

    Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Person)) {
            return false;
        }

        return String.valueOf(((Person) o).getName()).equals(String.valueOf(name));
    }
}
