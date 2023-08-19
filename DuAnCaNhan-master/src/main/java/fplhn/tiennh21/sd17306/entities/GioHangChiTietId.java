package fplhn.tiennh21.sd17306.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class GioHangChiTietId implements Serializable {
    private UUID gioHang;
    private UUID chiTietSp;
}
