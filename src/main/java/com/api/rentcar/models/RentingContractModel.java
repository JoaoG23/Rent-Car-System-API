
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "TB_RESTING_CONTRACTS")
public class RentingContractModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCodeContract;

    @Column(nullable = false)
    private LocalDateTime initialDateRent;
    
    
    @Column(nullable = false)
    private LocalDateTime finalDateRent;
    
    
    @Column(nullable = false)
    private LocalDateTime dateHappend;

    // Joins


    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarModel cars;

    @ManyToOne
    @JoinColumn(name = "lodger_id")
    private LodgerModel lodgers;




    @Column(nullable = true)
    private String observations;




    public Long getIdCodeContract() {
        return idCodeContract;
    }




    public void setIdCodeContract(Long idCodeContract) {
        this.idCodeContract = idCodeContract;
    }




    public LocalDateTime getInitialDateRent() {
        return initialDateRent;
    }




    public void setInitialDateRent(LocalDateTime initialDateRent) {
        this.initialDateRent = initialDateRent;
    }




    public LocalDateTime getFinalDateRent() {
        return finalDateRent;
    }




    public void setFinalDateRent(LocalDateTime finalDateRent) {
        this.finalDateRent = finalDateRent;
    }




    public LocalDateTime getDateHappend() {
        return dateHappend;
    }




    public void setDateHappend(LocalDateTime dateHappend) {
        this.dateHappend = dateHappend;
    }




    public CarModel getCars() {
        return cars;
    }




    public void setCars(CarModel cars) {
        this.cars = cars;
    }




    public LodgerModel getLodgers() {
        return lodgers;
    }




    public void setLodgers(LodgerModel lodgers) {
        this.lodgers = lodgers;
    }




    public String getObservations() {
        return observations;
    }




    public void setObservations(String observations) {
        this.observations = observations;
    }



    


}
