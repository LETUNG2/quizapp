package com.example.thibanglaixe

object setData {
    const val name:String="name"
    const val score:String="score"
    const val time12:String="00:00:00"
    fun getQuestion():ArrayList<QuestionData> {
        var que: ArrayList<QuestionData> = arrayListOf()
        var q1 = QuestionData(
            "Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?",
            1,
            "Phần mặt đường và lề đường",
            "Phần đường xe chạy",
            "Phần đường xe cơ giới",
            "Tất cả đáp án trên",
            2
        )
        var q2 = QuestionData(
            " “Làn đường” là gì?",
            2,
            "Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, sử dụng cho xe chạy",
            "Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn",
            "Là đường cho xe ô tô chạy, dừng, đỗ an toàn",
            "Tất cả đáp án trên",
            2
        )
        var q3= QuestionData(
            "Trong các khái niệm dưới đây, “dải phân cách” được hiểu như thế nào là đúng?",
            3, "Là bộ phận của đường để ngăn cách không cho các loại xe vào những nơi không được phép",
            "Là bộ phận của đường để phân tách phần đường xe chạy và hành lang an toàn giao thông.",
            "Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.",
            "Là người điều khiển xe thô sơ.",
            3
        )
        var q4=QuestionData(
            "“Dải phân cách” trên đường bộ gồm những loại nào?",
            4,
            "Dải phân cách gồm loại cố định và loại di động.",
            "Dải phân cách gồm tường chống ồn, hộ lan cứng và hộ lan mềm",
            "Dải phân cách gồm giá long môn và biển báo hiệu đường bộ",
            "Dải phân cách gồm hộ lan cứng và biển báo.",
            1
        )
        var q5=QuestionData(
            "Người lái xe được hiểu như thế nào trong các khái niệm dưới đây?",
            5,
            "Là người điều khiển xe cơ giới.",
            "Là người điều khiển xe thô sơ.",
            "Là người điều khiển xe có súc vật kéo",
            "là người đi bộ",
            1
        )
        var q6= QuestionData(
            "Đường mà trên đó phương tiện tham gia giao thông được các phương tiện giao thông đến từ các hướng khác nhường đường" + " khi qua nơi đường giao nhau, được cắm biển báo hiệu đường ưu tiên là loại đường gì?",
            6,
            "Đường không ưu tiên",
            "Đường tỉnh lộ.",
            "Đường quốc lộ.",
            "Đường ưu tiên.",
            4
        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        que.add(q6)
        return que
    }
}
