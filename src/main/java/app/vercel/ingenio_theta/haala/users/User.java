package app.vercel.ingenio_theta.haala.users;

import app.vercel.ingenio_theta.haala.accounts.Account;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@Table(name = "users")
public class User extends Account {
    private String bio;

    private String avatar;
}
