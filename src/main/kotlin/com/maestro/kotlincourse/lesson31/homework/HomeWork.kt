import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

enum class JobPosition {
    CHIEF_TECH_OFFICER, LEAD_ENGINEER, SOFTWARE_ENGINEER, UX_DESIGNER, QUALITY_ASSURANCE
}

data class Employee(
    val name: String,
    val employed: Boolean,
    val dob: String,
    val position: JobPosition,
    val subordinates: List<Employee> = emptyList()
)

fun main() {
    val cto = Employee(
        "Екатерина Иванова", true, "1970-09-12", JobPosition.CHIEF_TECH_OFFICER,
        subordinates = listOf(
            Employee(
                "Иван Иванов", true, "1982-11-15", JobPosition.LEAD_ENGINEER,
                subordinates = listOf(
                    Employee("Софья Авакумова", true, "1990-04-03", JobPosition.SOFTWARE_ENGINEER),
                    Employee("Моргана", true, "1991-08-22", JobPosition.UX_DESIGNER)
                )
            ),
            Employee(
                "анастасия Ильина", true, "1985-06-30", JobPosition.LEAD_ENGINEER,
                subordinates = listOf(
                    Employee("Анатолий ", true, "1989-02-14", JobPosition.SOFTWARE_ENGINEER),
                    Employee("Антон", true, "1993-12-05", JobPosition.QUALITY_ASSURANCE)
                )
            )
        )
    )

    val filePath = "cтруктура.json"
    val gson: Gson = GsonBuilder().setPrettyPrinting().create()
    File(filePath).writeText(gson.toJson(cto))
    println("Сохранено: $filePath")

    val jsonData = File(filePath).readText()
    val deserializedCto = gson.fromJson(jsonData, Employee::class.java)

    println("\nСтруктура:")
    printEmployeeHierarchy(deserializedCto, 0)
}

fun printEmployeeHierarchy(employee: Employee, level: Int) {
    println("${" ".repeat(level * 4)}- ${employee.position}: ${employee.name} (DOB: ${employee.dob})")
    employee.subordinates.forEach { printEmployeeHierarchy(it, level + 1) }
}