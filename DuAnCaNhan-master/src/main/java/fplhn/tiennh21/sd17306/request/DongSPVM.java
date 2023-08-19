package fplhn.tiennh21.sd17306.request;

import fplhn.tiennh21.sd17306.entities.DongSP;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class DongSPVM {
    @NotBlank(message = "Mã không được để trống")
    private String ma;

    @NotBlank(message = "Tên không được để trống")
    private String ten;

    public void loadFromDomainModel(DongSP domain){
        this.setTen(domain.getTen());
        this.setMa(domain.getMa());
    }
}
