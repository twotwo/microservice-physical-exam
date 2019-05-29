# microservice-physical-exam
a microservice demo for physical examination.

[体检](https://en.wikipedia.org/wiki/Physical_examination)，也称做身体检查、理学检查或健康检查，是医生检查病人身体，以确定其是否有某种疾病的迹象或症状的过程。它通常包括一系列关于病人病史的问题，然后检查症状。病史和体格检查有助于确定正确的诊断和制定治疗计划。这些数据成为医疗记录的一部分。

## Use Cases

```plantuml
@startuml
left to right direction
skinparam packageStyle rectangle
actor patient
actor doctor
actor his <<application>>
rectangle exam {
  patient -- (appointment)
  (appointment) .> (order exams) : include
  (appointment) .> (payment) : include
  appointment --> his
  patient -- (examination)
  (examination) .> (write medical record) : include
  (write medical record) --> his
  (examination) -- doctor
  patient -- (read medical report)
  (read medical report) -- his
}
@enduml
```

## Sequence Diagrams

### Appointment

```plantuml
@startuml
autonumber
patient -> his : Make an Appointment for Exam
patient <- his : Reservation form Response
patient -> his : Order an Exam
patient <- his : Payment form Response
patient -> his : Pay for the Order
@enduml
```

### Examination

```plantuml
@startuml
autonumber
patient -> doctor : Request Exam xxx
patient <- doctor : Perform Exam xxx
his <- doctor : Record Exam xxx
patient <- doctor : Finish Exam
@enduml
```

### Medical Report

```plantuml
@startuml
autonumber
patient -> his : Request for Medical Report
patient <- his : Medical Report Response
@enduml
```

## Environment

### mysql

`docker run -it --network baas --rm mariadb:10.3 mysql -hphysical-exam-mysql -uroot -psecret`