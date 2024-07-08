CREATE TABLE charge_detail (
  id UUID NOT NULL,
   vehicle_id VARCHAR(255) NOT NULL,
   created_date TIMESTAMP,
   end_date TIMESTAMP,
   cost DECIMAL(19, 2),
   version INT,
   CONSTRAINT pk_charge_detail PRIMARY KEY (id)
);

CREATE INDEX idx_charge_detail_vehicle_id ON charge_detail(vehicle_id);