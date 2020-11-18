package model;

public abstract class AbstractBaseEntity {
    public static final int START_SEQ = 100000;
    protected Integer id;

    public AbstractBaseEntity() {
    }

    public AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Boolean isNew() {
        return this.id == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractBaseEntity that = (AbstractBaseEntity) o;
        return id != null && id.equals(that.id);
    }

    public int hashCode() {
        return id == null ? 0 : id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + id;
    }
}
