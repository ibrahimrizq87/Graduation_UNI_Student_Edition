package com.uni.unistudent.data



import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.uni.unistudent.classes.*
import com.uni.unistudent.data.di.FireStoreTable
import com.uni.unistudent.data.di.PermissionsRequired
import com.uni.unistudent.data.di.PostType
import javax.inject.Inject

class FirebaseRepoImp@Inject constructor(
   private val database:FirebaseFirestore

):FirebaseRepo{
//TODO convert the get schedule and posts to a normal get functions not to use the data snapshot and real-time update functions
    override suspend fun updateCommentGeneralPosts(
        comment: Comment,
        postID: String,
        result: (Resource<String>) -> Unit
    ) {
        val document=database.collection(FireStoreTable.post).document(postID).collection(FireStoreTable.comment).document(comment.commentID)
        document.set(comment)
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("comment updated successfully")
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

    override suspend fun updateCommentSectionPosts(
        comment: Comment,
        postID: String,
        section: String,
        dep: String,

        result: (Resource<String>) -> Unit
    ) {

        val document=database.collection(PostType.section_posts).document(dep).collection(section)
            .document(postID).collection(FireStoreTable.comment).document(comment.commentID)

        document.set(comment)
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("comment updated successfully")
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

    override suspend fun updateCommentCoursePosts(
        comment: Comment,
        postID: String,
        courseID: String,
        result: (Resource<String>) -> Unit
    ) {
        val document=database.collection(FireStoreTable.courses).document(courseID).collection(FireStoreTable.post)
            .document(postID).collection(FireStoreTable.comment).document(comment.commentID)
        document.set(comment)
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("comment updated successfully")
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

    override suspend fun updateCommentPersonalPosts(
        comment: Comment,
        postID: String,
        userID: String,
        result: (Resource<String>) -> Unit
    ) {
        val document=database.collection(PostType.personal_posts).document(userID).collection(FireStoreTable.post)
            .document(postID).collection(FireStoreTable.comment).document(comment.commentID)

        document.set(comment)
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("comment updated successfully")
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
    override suspend fun deleteCommentGeneralPosts(
        comment: Comment,
        postID: String,
        result: (Resource<String>) -> Unit
    ) {
        val document=database.collection(FireStoreTable.post).document(postID).collection(FireStoreTable.comment).document(comment.commentID)
        document.delete()
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("comment deleted successfully")
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

    override suspend fun deleteCommentSectionPosts(
        comment: Comment,
        postID: String,
        section: String,
        dep: String,

        result: (Resource<String>) -> Unit
    ) {

        val document=database.collection(PostType.section_posts).document(dep).collection(section)
            .document(postID).collection(FireStoreTable.comment).document(comment.commentID)

        document.delete()
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("comment deleted successfully")
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

    override suspend fun deleteCommentCoursePosts(
        comment: Comment,
        postID: String,
        courseID: String,
        result: (Resource<String>) -> Unit
    ) {
        val document=database.collection(FireStoreTable.courses).document(courseID).collection(FireStoreTable.post)
            .document(postID).collection(FireStoreTable.comment).document(comment.commentID)
        document.delete()
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("comment deleted successfully")
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

    override suspend fun deleteCommentPersonalPosts(
        comment: Comment,
        postID: String,
        userID: String,
        result: (Resource<String>) -> Unit
    ) {
        val document=database.collection(PostType.personal_posts).document(userID).collection(FireStoreTable.post)
            .document(postID).collection(FireStoreTable.comment).document(comment.commentID)

        document.delete()
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("comment deleted successfully")
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



    override suspend fun updateSectionAttendance(
        attendance: Attendance,
        section: Section,
        result: (Resource<String>) -> Unit
    ) {
        val document = database.collection(FireStoreTable.courses)
            .document(section.courseCode)
            .collection(FireStoreTable.sections)
            .document(section.dep)
            .collection(section.section).document(section.sectionId).collection(FireStoreTable.attendance).document()
        attendance.attendanceID=document.id
        document.set(attendance)
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("attendance added successfully")
                )
            }
            .addOnFailureListener {
                result.invoke(
                    Resource.Failure(
                        it.localizedMessage
                    )
                )
            }
    }
    override suspend fun updateLectureAttendance(
        attendance: Attendance,
        lecture: Lecture,
        result: (Resource<String>) -> Unit
    ) {
        val document = database.collection(FireStoreTable.courses).document(lecture.courseCode)
            .collection(FireStoreTable.lectures)
            .document(lecture.dep)
            .collection(lecture.dep)
            .document(lecture.lectureId)
            .collection(FireStoreTable.attendance).document()
        attendance.attendanceID=document.id

        document.set(attendance)
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("attendance added successfully")
                )
            }
            .addOnFailureListener {
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
                Log.e("coures-test-walid", post.courseCode)
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

    override suspend fun getGeneralPosts(result: (Resource<List<Posts>>) -> Unit) {
        val docRef = database.collection(FireStoreTable.post)
        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }

            val listOfPosts= arrayListOf<Posts>()
            for (rec in snapshot!!){
                val post = rec.toObject(Posts::class.java)
                listOfPosts.add(post)
            }
            result.invoke(Resource.Success(listOfPosts))
        }
    }

    override suspend fun getSectionPosts(
        section: String,
        dep: String,

        result: (Resource<List<Posts>>) -> Unit
    ) {
        val document=database.collection(PostType.section_posts).document(dep).collection(section)

        document.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }

            val listOfPosts= arrayListOf<Posts>()
            for (rec in snapshot!!){
                val post = rec.toObject(Posts::class.java)
                listOfPosts.add(post)
            }
            result.invoke(Resource.Success(listOfPosts))
        }
    }
    override suspend fun getPosts(
        courses: List<Courses>,
        section: String,
        dep: String,
        userID: String,
        result: (Resource<List<Posts>>) -> Unit
    ) {
        val listOfPosts= arrayListOf<Posts>()
        for(course in courses){
            val document=database.collection(FireStoreTable.courses).document(course.courseCode).collection(FireStoreTable.post)

            document.addSnapshotListener { snapshot, e ->
                if (e != null) {
                    result.invoke(Resource.Failure(e.toString()))
                    return@addSnapshotListener
                }
                for (rec in snapshot!!){
                    val post = rec.toObject(Posts::class.java)
                    listOfPosts.add(post)
                }

            }    }

        val document=database.collection(PostType.personal_posts).document(userID).collection(FireStoreTable.post)

        document.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }

            for (rec in snapshot!!){
                val post = rec.toObject(Posts::class.java)
                listOfPosts.add(post)
            }
        }

            val document2=database.collection(PostType.section_posts).document(dep).collection(section)

            document2.addSnapshotListener { snapshot, e ->
                if (e != null) {
                    result.invoke(Resource.Failure(e.toString()))
                    return@addSnapshotListener
                }

                for (rec in snapshot!!){
                    val post = rec.toObject(Posts::class.java)
                    listOfPosts.add(post)
                }


    }

        val docRef = database.collection(FireStoreTable.post)
        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }

            for (rec in snapshot!!){
                val post = rec.toObject(Posts::class.java)
                listOfPosts.add(post)
            }
        }

        result.invoke(Resource.Success(listOfPosts))

    }

    override suspend fun getCoursePosts(courses: List<Courses>, result: (Resource<List<Posts>>) -> Unit) {
        val listOfPosts= arrayListOf<Posts>()
        for(course in courses){
        val document=database.collection(FireStoreTable.courses).document(course.courseCode).collection(FireStoreTable.post)

        document.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }
            for (rec in snapshot!!){
                val post = rec.toObject(Posts::class.java)
                Log.e("MMNNBB",post.postID)
                listOfPosts.add(post)
            }

        }    }
        result.invoke(Resource.Success(listOfPosts))
    }

    override suspend fun getPersonalPosts(userID: String, result: (Resource<List<Posts>>) -> Unit) {
        val document=database.collection(PostType.personal_posts).document(userID).collection(FireStoreTable.post)

        document.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }

            val listOfPosts= arrayListOf<Posts>()
            for (rec in snapshot!!){
                val post = rec.toObject(Posts::class.java)
                Log.e("lesiner",post.audience)
                listOfPosts.add(post)
            }
            result.invoke(Resource.Success(listOfPosts))
        }
    }


    override suspend fun addCommentGeneralPosts(
        comment: Comment,
        postID: String,
        result: (Resource<String>) -> Unit
    ) {
        val document=database.collection(FireStoreTable.post).document(postID).collection(FireStoreTable.comment).document()
        comment.commentID=document.id
        document.set(comment)
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("comment added successfully")
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

    override suspend fun addCommentSectionPosts(
        comment: Comment,
        postID: String,
        section: String,
        dep: String,

        result: (Resource<String>) -> Unit
    ) {

        val document=database.collection(PostType.section_posts).document(dep).collection(section)
            .document(postID).collection(FireStoreTable.comment).document()
        comment.commentID=document.id
        document.set(comment)
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("comment added successfully")
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

    override suspend fun addCommentCoursePosts(
        comment: Comment,
        postID: String,
        courseID: String,
        result: (Resource<String>) -> Unit
    ) {
        val document=database.collection(FireStoreTable.courses).document(courseID).collection(FireStoreTable.post)
            .document(postID).collection(FireStoreTable.comment).document()
        comment.commentID=document.id
        document.set(comment)
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("comment added successfully")
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

    override suspend fun addCommentPersonalPosts(
        comment: Comment,
        postID: String,
        userID: String,
        result: (Resource<String>) -> Unit
    ) {
        val document=database.collection(PostType.personal_posts).document(userID).collection(FireStoreTable.post)
            .document(postID).collection(FireStoreTable.comment).document()
        comment.commentID=document.id
        document.set(comment)
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("comment added successfully")
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








override suspend fun getCommentGeneralPosts(
    postID: String,
    result: (Resource<List<Comment>>) -> Unit
) {
    val document=database.collection(FireStoreTable.post)
        .document(postID).collection(FireStoreTable.comment).orderBy("time", Query.Direction.ASCENDING)

    document.addSnapshotListener { snapshot, e ->
        if (e != null) {
            result.invoke(Resource.Failure(e.toString()))
            return@addSnapshotListener
        }

        val listOfPosts= arrayListOf<Comment>()
        for (rec in snapshot!!){
            val post = rec.toObject(Comment::class.java)
            listOfPosts.add(post)
        }
        result.invoke(Resource.Success(listOfPosts))
    }

}

    override suspend fun getCommentSectionPosts(
        postID: String,
        section: String,
        dep: String,

        result: (Resource<List<Comment>>) -> Unit
    ) {
        val document=database.collection(PostType.section_posts).document(dep).collection(section)
            .document(postID).collection(FireStoreTable.comment).orderBy("time", Query.Direction.ASCENDING)
        document.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }

            val listOfPosts= arrayListOf<Comment>()
            for (rec in snapshot!!){
                val post = rec.toObject(Comment::class.java)
                listOfPosts.add(post)
            }
            result.invoke(Resource.Success(listOfPosts))
        }
    }

    override suspend fun getCommentCoursePosts(
        postID: String,
        courseID: String,
        result: (Resource<List<Comment>>) -> Unit
    ) {
        val document=database.collection(FireStoreTable.courses).document(courseID).collection(FireStoreTable.post)
            .document(postID).collection(FireStoreTable.comment).orderBy("time", Query.Direction.ASCENDING)
        document.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }

            val listOfPosts= arrayListOf<Comment>()
            for (rec in snapshot!!){
                val post = rec.toObject(Comment::class.java)
                listOfPosts.add(post)
            }
            result.invoke(Resource.Success(listOfPosts))
        }


    }

    override suspend fun getCommentPersonalPosts(
        postID: String,
        userID: String,
        result: (Resource<List<Comment>>) -> Unit
    ) {
        val document = database.collection(PostType.personal_posts).document(userID)
            .collection(FireStoreTable.post)
            .document(postID).collection(FireStoreTable.comment)
            .orderBy("time", Query.Direction.ASCENDING)
        document.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }

            val listOfPosts = arrayListOf<Comment>()
            for (rec in snapshot!!) {
                val post = rec.toObject(Comment::class.java)
                listOfPosts.add(post)
            }
            result.invoke(Resource.Success(listOfPosts))
        }
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

    override suspend fun getPermission(
        userId: String,
        result: (Resource<Permission?>) -> Unit
    ) {
        val docRef =  database.collection(PermissionsRequired.sing_in_permission)
            .document(userId)

        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }
            result.invoke(Resource.Success(snapshot?.toObject(Permission::class.java)))
        }   }

    override suspend fun getSection(
        courses: List<Courses>,
        dep: String,
        section: String,
        result: (Resource<List<Section>>) -> Unit
    ) {
        val listOfPosts = arrayListOf<Section>()
        for (course in courses) {
            Log.e("repo",course.courseCode)
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
                    Log.e("i am here section",post.assistantName)
                    listOfPosts.add(post)
                }

            }
        }
        result.invoke(Resource.Success(listOfPosts))

    }

    override  fun getLectures(courses: List<Courses>,dep:String, result: (Resource<List<Lecture>>) -> Unit) {
        val listOfPosts = arrayListOf<Lecture>()
        for (course in courses) {
            Log.e("i am here",course.courseCode)
            val docRef = database.
            collection(FireStoreTable.courses).
            document(course.courseCode)
            .collection(FireStoreTable.lectures)
                .document(dep).
                collection(dep)
            docRef.addSnapshotListener { snapshot, e ->
                if (e != null) {
                    result.invoke(Resource.Failure(e.toString()))
                    return@addSnapshotListener
                }
                for (rec in snapshot!!) {
                    val post = rec.toObject(Lecture::class.java)
                    Log.e("i am here",post.professorName)
                    listOfPosts.add(post)
                }

            }


        }
        result.invoke(Resource.Success(listOfPosts))


    }

     override fun getLectures2(courses: List<Courses>,dep:String, result: (List<Lecture>?) -> Unit) {
        val listOfPosts = arrayListOf<Lecture>()
        for (course in courses) {
            Log.e("i am here",course.courseCode)
            val docRef = database.
            collection(FireStoreTable.courses).
            document(course.courseCode)
                .collection(FireStoreTable.lectures)
                .document(dep).
                collection(dep)
            docRef.addSnapshotListener { snapshot, e ->
                if (e != null) {
                    result.invoke(null)
                    return@addSnapshotListener
                }
                for (rec in snapshot!!) {
                    val post = rec.toObject(Lecture::class.java)
                    Log.e("i am here",post.professorName)
                    listOfPosts.add(post)
                }

            }


        }
        result.invoke(listOfPosts)


    }


}
