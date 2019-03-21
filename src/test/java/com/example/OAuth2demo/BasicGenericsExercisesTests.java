package com.example.OAuth2demo;

import org.junit.Test;

public class BasicGenericsExercisesTests {
    private class Generic<T> {
        private T value;
        public T getValueType(){
            return value;
        }
        public void setValueType(T value) {
            this.value = value;
        }

        public void manipulate(){

            System.out.println("The second letter is " + value.toString());
        }
        public boolean equalsValueType(T newValue){
            return value.equals(newValue);
        }
    }

    @Test
    public void extendingWildcard() {
        Generic<? super Number> unknownType = new Generic<>();
        unknownType.setValueType(3);
        unknownType.setValueType(4.3);
    }

    @Test
    public void passInGeneric() {
        Generic<String> stringGeneric = new Generic<>();
        stringGeneric.setValueType("hi");
        System.out.println("Generic String: " + stringGeneric.getValueType() + "\n");
        System.out.printf("Equals hi: " + stringGeneric.equalsValueType("hi"));

        Generic<Integer> integerGeneric = new Generic<>();
        integerGeneric.setValueType(3);
        System.out.printf("Generic Integer: " + integerGeneric.getValueType() + "\n");
        System.out.printf("Equals 3: " + integerGeneric.equalsValueType(3));

        Generic<NoorulType> noorulTypeGeneric = new Generic<>();
        NoorulType value = new NoorulType();
        value.setName("Noorul");
        noorulTypeGeneric.setValueType(value);
        System.out.printf("Noorul Generic: " + noorulTypeGeneric.getValueType().getName() + "\n");
        NoorulType noorulType = new NoorulType();
        noorulType.setName("Noorul");
        System.out.printf("Equals same reference to NoorulType object: " + noorulTypeGeneric.equalsValueType(noorulType));

    }

    @Test
    public void genericsWildcard() {
        Generic<String> stringGeneric = new Generic<>();
        stringGeneric.manipulate();
    }
}
