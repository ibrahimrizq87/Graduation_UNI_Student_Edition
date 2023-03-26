package com.uni.unistudent.data



import com.google.firebase.firestore.FirebaseFirestore
import com.uni.unistudent.Classes.*
import com.uni.unistudent.data.di.FireStoreTable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class FirebaseRepoImp@Inject constructor(
   private val database:FirebaseFirestore

):FirebaseRepo{
    override suspend fun updateSectionAttendance(attendance: Attendance, sectionId: String, result: (Resource<String>) -> Unit) {
        val document=database.collection(FireStoreTable.attendance).document(FireStoreTable.sections)
            .collection(sectionId)
        document.add(attendance)
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("attendance added successfully")
                )
            }
            .addOnFailureListener{
                result.invoke(
                    Resource.Failure(
                        it.localizedMessage
                    )
                )
            }
    }
    override suspend fun updateLectureAttendance(attendance: Attendance,lectureId: String, result: (Resource<String>) -> Unit) {
        val document=database.collection(FireStoreTable.attendance).document(FireStoreTable.lectures)
            .collection(lectureId)
        document.add(attendance)
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("attendance added successfully")
                )
            }
            .addOnFailureListener{
                result.invoke(
                    Resource.Failure(
                        it.localizedMessage
                    )
                )
            }
    }
    override suspend fun getCourse( grade:String,result: (Resource<List<Courses>>) -> Unit) {
        val docRef = database.collection(FireStoreTable.courses)
            .whereEqualTo("grade", grade)
        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }
            val listOfPosts= arrayListOf<Courses>()
            for (rec in snapshot!!){
                val post = rec.toObject(Courses::class.java)
                listOfPosts.add(post)
            }
            result.invoke(Resource.Success(listOfPosts))
        }
    }
    override suspend fun getCourseByProfessorCode( professorCode:String,result: (Resource<List<Courses>>) -> Unit) {
        val docRef = database.collection(FireStoreTable.courses)
            .whereEqualTo("professor", professorCode)
        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }

            val listOfPosts= arrayListOf<Courses>()
            for (rec in snapshot!!){
                val post = rec.toObject(Courses::class.java)
                listOfPosts.add(post)
            }
            result.invoke(Resource.Success(listOfPosts))
        }
    }
    override suspend fun getCourseByAssistantCode( assistantCode:String,result: (Resource<List<Courses>>) -> Unit) {
        val docRef = database.collection(FireStoreTable.courses)
            .whereEqualTo("learningAssistant", assistantCode)
        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }

            val listOfPosts= arrayListOf<Courses>()
            for (rec in snapshot!!){
                val post = rec.toObject(Courses::class.java)
                listOfPosts.add(post)
            }
            result.invoke(Resource.Success(listOfPosts))
        }
    }

    override suspend fun getAssistant(
        courses: List<Courses>,
        result: (Resource<List<Assistant>>) -> Unit
    ) {
        val listOfPosts = arrayListOf<Assistant>()
        for (course in courses) {
            val docRef = database.collection(FireStoreTable.courses).document(course.courseCode)
                .collection(FireStoreTable.assistant)
            docRef.addSnapshotListener { snapshot, e ->
                if (e != null) {
                    result.invoke(Resource.Failure(e.toString()))
                    return@addSnapshotListener
                }
                for (rec in snapshot!!) {
                    val post = rec.toObject(Assistant::class.java)
                    listOfPosts.add(post)
                }

            }
        }
        result.invoke(Resource.Success(listOfPosts))
    }




    override suspend fun getProfessor(
        courses: List<Courses>,
        result: (Resource<List<Professor>>) -> Unit
    ) {
        val listOfPosts = arrayListOf<Professor>()
        for (course in courses) {
            val docRef = database.collection(FireStoreTable.courses).document(course.courseCode)
                .collection(FireStoreTable.professor)
            docRef.addSnapshotListener { snapshot, e ->
                if (e != null) {
                    result.invoke(Resource.Failure(e.toString()))
                    return@addSnapshotListener
                }
                for (rec in snapshot!!) {
                    val post = rec.toObject(Professor::class.java)
                    listOfPosts.add(post)
                }

            }
        }
        result.invoke(Resource.Success(listOfPosts))

    }

    override suspend fun getSection(
        courses: List<Courses>,
        dep: String,
        section: String,
        result: (Resource<List<Section>>) -> Unit
    ) {
        val listOfPosts = arrayListOf<Section>()
        for (course in courses) {
            val docRef =
                database.collection(FireStoreTable.courses)
                    .document(course.courseCode)
                    .collection(FireStoreTable.sections)
                    .document(dep)
                    .collection(section)
            docRef.addSnapshotListener { snapshot, e ->
                if (e != null) {
                    result.invoke(Resource.Failure(e.toString()))
                    return@addSnapshotListener
                }
                for (rec in snapshot!!) {
                    val post = rec.toObject(Section::class.java)
                    listOfPosts.add(post)
                }

            }
        }
        result.invoke(Resource.Success(listOfPosts))

    }

    override suspend fun getLectures(courses: List<Courses>,dep:String, result: (Resource<List<Lecture>>) -> Unit) {
        val listOfPosts = arrayListOf<Lecture>()
        for (course in courses) {
            val docRef = database.collection(FireStoreTable.courses).document(course.courseCode)
                .collection(FireStoreTable.lectures)
            docRef.addSnapshotListener { snapshot, e ->
                if (e != null) {
                    result.invoke(Resource.Failure(e.toString()))
                    return@addSnapshotListener
                }
                for (rec in snapshot!!) {
                    val post = rec.toObject(Lecture::class.java)
                    listOfPosts.add(post)
                }

            }
            for (course in courses) {
                val docRef = database.collection(FireStoreTable.courses).document(course.courseCode)
                    .collection(FireStoreTable.lectures).document(dep)
                    .collection(FireStoreTable.lectures)
                docRef.addSnapshotListener { snapshot, e ->
                    if (e != null) {
                        result.invoke(Resource.Failure(e.toString()))
                        return@addSnapshotListener
                    }
                    for (rec in snapshot!!) {
                        val post = rec.toObject(Lecture::class.java)
                        listOfPosts.add(post)
                    }

                }
            }
            result.invoke(Resource.Success(listOfPosts))
        }



    }
}
