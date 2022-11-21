package com.demo.models;


import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@Entity
@NamedNativeQuery(name = "Seat.getAdminAvailableSeats", query = "select distinct a.id, a.position, case when b.status is null or b.status = 0 then 0 else 1 end as status \r\n"
		+ "from seat a left join ticket b on a.id = b.seat_id and b.hall_id = :hall_id and b.movie_show_time_id = :movie_show_time_id where b.status is null or b.status = 0 order by a.id", resultSetMapping = "AdminAvailableSeatsQuery")
@SqlResultSetMapping(name = "AdminAvailableSeatsQuery", classes = {
		@ConstructorResult(targetClass = AdminAvailableSeats.class, columns = { @ColumnResult(name = "id"),
				@ColumnResult(name = "position"), @ColumnResult(name = "status") }) })
public class AdminAvailableSeats {
	@Id int fake_id;
	private Integer id;
	private String position;
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}



	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public AdminAvailableSeats(Integer id, String position, Integer status) {
		super();
		this.id = id;
		this.position = position;
		this.status = status;
	}

	public AdminAvailableSeats() {
		super();
	}

}
