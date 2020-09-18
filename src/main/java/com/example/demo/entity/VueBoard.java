package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cafe_board")
public class VueBoard {
    // Id = primary key
    @Id
    // autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private long boardNo;
    // nullable= null
    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 200, nullable = false)
    private String content;

    @Column(length = 16, nullable = false)
    private String writer;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreationTimestamp
    @Column(columnDefinition = "datetime default now()")
    private Date regDate;
}
//package com.example.demo.entity;
//
//        import com.fasterxml.jackson.annotation.JsonFormat;
//        import lombok.Getter;
//        import lombok.Setter;
//        import lombok.ToString;
//        import org.hibernate.annotations.CreationTimestamp;
//        import org.hibernate.annotations.UpdateTimestamp;
//
//        import javax.persistence.*;
//        import java.util.Date;
//
//@Getter
//@Setter
//@ToString
//public class CafeBoard {
//    private long boardNo;
//    private String title;
//    private String content;
//    private String writer;
//    private Date regDate;
//}
