package com.maestro.com.maestro.kotlincourse.lesson17.homework

class EducationalInstitution {
    open class EducationalInstitution(val name: String)

    class School : EducationalInstitution("School")

    class University : EducationalInstitution("University")

}