package uz.wh.db.entities.base;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Calendar;
import java.util.UUID;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class DocumentEntity extends BaseEntity {

    @NotNull
    @Column(name = "document_registered_at", updatable = false)
    private Calendar registeredAt;

    @Nullable
    @Column(name = "document_registered_by")
    private UUID registeredBy;

    @NotNull
    @Column(name = "document_reference")
    private String reference;

    @Nullable
    @Column(name = "document_notes")
    private String notes;

}
