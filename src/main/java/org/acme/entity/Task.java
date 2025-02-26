package org.acme.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;

/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 *
 * This uses the active record pattern, you can also use the repository pattern instead:
 * .
 *
 * Usage (more example on the documentation)
 *
 * {@code
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         entity1.persist();
 *
 *         List<MyEntity> entities = MyEntity.listAll();
 *     }
 * }
 */
@Entity
public class Task extends PanacheEntity {

    public String name;
    public String description;
    public Status status;

    public static Task findByName(String name){
            return find("name",name).firstResult();
    }

    @Transactional
    public static void add(Task task){
        persist(task);
    }

    @Transactional
    public static void update(Task task){
        Task.update("UPDATE Task SET status=?1, description=?2, name=?3 where id=?4",task.status,task.description,task.name,task.id);
    }
}
