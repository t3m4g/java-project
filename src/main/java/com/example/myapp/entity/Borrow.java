package com.example.myapp.entity;


import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_begin", nullable = false)
    private Date dateBegin;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_end")
    private Date dateEnd;

    @Enumerated(EnumType.STRING)
    @Column(name = "borrow_status", nullable = false)
    private BorrowStatus borrowStatus;

    // Constructeurs
    public Borrow() {
    }

    public Borrow(User user, Book book, Date dateBegin, Date dateEnd, BorrowStatus borrowStatus) {
        this.user = user;
        this.book = book;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.borrowStatus = borrowStatus;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public BorrowStatus getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(BorrowStatus borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    // Méthode utilitaire pour vérifier si l'emprunt est en cours
    public boolean isBorrowInProgress() {
        return BorrowStatus.EN_COURS.equals(this.borrowStatus);
    }

    // Méthode utilitaire pour vérifier si l'emprunt est terminé
    public boolean isBorrowCompleted() {
        return BorrowStatus.TERMINE.equals(this.borrowStatus);
    }

    // Enumération pour le statut de l'emprunt
    public enum BorrowStatus {
        EN_COURS, TERMINE
    }

    // Méthode toString pour le débogage
    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                ", borrowStatus=" + borrowStatus +
                '}';
    }
}