package uz.wh.db.entities.base;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", insertable = false, updatable = false, nullable = false)
    private UUID id;

    @Nullable
    @Column(name = "is_deleted")
    private boolean deleted = false;

    @Nullable
    @Column(name = "for_deletion")
    private boolean forDeletion = false;

    /*
     * From now you can use Calendar object which is newer than Date.
     * It has more capabilities.
     *
     * For more info: https://www.geeksforgeeks.org/calendar-class-in-java-with-examples/
     * Official documentation: https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
     */
    @Column(name = "created_at", updatable = false)
    private Calendar createdAt;

    @Column(name = "updated_at")
    private Calendar updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = Objects.nonNull(this.createdAt) ? this.createdAt : Calendar.getInstance();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Objects.nonNull(this.updatedAt) ? this.updatedAt : Calendar.getInstance();
    }

}
