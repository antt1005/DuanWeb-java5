package fplhn.tiennh21.sd17306.request;

import fplhn.tiennh21.sd17306.entities.CuaHang;
import fplhn.tiennh21.sd17306.entities.MauSac;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class MauSacVM {
    @NotBlank(message = "Không được để trống")
    @Length(max = 255, message = "Không vượt quá 255 kí tự")
    private String ma;

    @NotBlank
    @Length(max = 255)
    private String ten;



}
