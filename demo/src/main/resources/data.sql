-- User
INSERT INTO users(email, name, password, surname, user_type)
VALUES ('aleksandarsarovic@yahoo.com', 'Aleksandar', 'sifra', 'Sarovic', 1);

-- Building orderer
INSERT INTO building_orderers(user_id) VALUES (1);

-- Facade
INSERT INTO facades(facade_adhesive_kilos, facade_final_mass_kilos, facade_net_surface_area, styrofoam_surface_area, styrofoam_width)
VALUES (0, 0, 0, 0, 8);

-- Heating
INSERT INTO heatings(heating_pipe_meters, heating_type, heating_units_counter)
VALUES (0, 2, 0);

-- Roof
INSERT INTO roofs(length_per_side, number_of_sides, roof_elements_counter, surface_area_for_boarding, surface_area_for_decking, surface_area_for_foiling)
VALUES (0, 2, 0, 0, 0, 0);

-- Roof cover unit
INSERT INTO roof_cover_units(height, length, level_of_energy_efficiency, roof_cover_type, width, for_roof_roof_id)
VALUES (2.65, 42, 5, 2, 30, 1);

-- Building
INSERT INTO buildings(active, built, created_at, building_material_estimation_bme_id, building_orderer_user_id,
                      facade_facade_id, heating_heating_id, roof_roof_id, work_force_estimation_wfc_id)
VALUES (true, false, '2021-01-01 12:00:00', null, 1, 1, 1, 1, null);

-- Floor
INSERT INTO floors(surface_area, concrete_structure_concrete_structure_id, floor_for_building_building_id)
VALUES (87, null, 1);
INSERT INTO floors(surface_area, concrete_structure_concrete_structure_id, floor_for_building_building_id)
VALUES (87, null, 1);

-- Rooms
-- 1. Floor
INSERT INTO rooms(flooring, purpose, surface_area, rooms_for_floor_floor_id)
VALUES (2, 2, 57, 1);
INSERT INTO rooms(flooring, purpose, surface_area, rooms_for_floor_floor_id)
VALUES (1, 2, 30, 1);

-- 2. Floor
INSERT INTO rooms(flooring, purpose, surface_area, rooms_for_floor_floor_id)
VALUES (2, 2, 30, 2);
INSERT INTO rooms(flooring, purpose, surface_area, rooms_for_floor_floor_id)
VALUES (2, 2, 40, 2);
INSERT INTO rooms(flooring, purpose, surface_area, rooms_for_floor_floor_id)
VALUES (1, 1, 17, 2);

-- Wall unit
INSERT INTO wall_units(height, length, width, wall_unit_type, product_category)
VALUES (9, 19, 9, 0, 14); -- small brick

INSERT INTO wall_units(height, length, width, wall_unit_type, product_category)
VALUES (5.2, 24, 11.5, 0, 14); -- medium brick

INSERT INTO wall_units(height, length, width, wall_unit_type, product_category)
VALUES (11.3, 24, 11.5, 0, 14); -- large brick

-- Wall
-- 1. Floor
INSERT INTO walls(length, height, wall_elements_counter, wall_unit_wall_unit_id, walls_for_floor_floor_id)
VALUES (490, 245 , 0, 2, 1);
INSERT INTO walls(length, height, wall_elements_counter, wall_unit_wall_unit_id, walls_for_floor_floor_id)
VALUES (490, 245 , 0, 2, 1);
INSERT INTO walls(length, height, wall_elements_counter, wall_unit_wall_unit_id, walls_for_floor_floor_id)
VALUES (250, 245 , 0, 2, 1);
INSERT INTO walls(length, height, wall_elements_counter, wall_unit_wall_unit_id, walls_for_floor_floor_id)
VALUES (250, 245 , 0, 2, 1);

-- 2. Floor
INSERT INTO walls(length, height, wall_elements_counter, wall_unit_wall_unit_id, walls_for_floor_floor_id)
VALUES (490, 245 , 0, 2, 2);
INSERT INTO walls(length, height, wall_elements_counter, wall_unit_wall_unit_id, walls_for_floor_floor_id)
VALUES (490, 245 , 0, 2, 2);
INSERT INTO walls(length, height, wall_elements_counter, wall_unit_wall_unit_id, walls_for_floor_floor_id)
VALUES (250, 245 , 0, 2, 2);
INSERT INTO walls(length, height, wall_elements_counter, wall_unit_wall_unit_id, walls_for_floor_floor_id)
VALUES (250, 245 , 0, 2, 2);

-- Carpentry units
-- 1. Floor
INSERT INTO carpentry_units(door, height, material, width, carpentry_for_floor_floor_id)
VALUES (true, 200, 1, 55, 1);
INSERT INTO carpentry_units(door, height, material, width, carpentry_for_floor_floor_id)
VALUES (false, 100, 1, 150, 1);

-- 2. Floor
INSERT INTO carpentry_units(door, height, material, width, carpentry_for_floor_floor_id)
VALUES (true, 200, 1, 55, 2);
INSERT INTO carpentry_units(door, height, material, width, carpentry_for_floor_floor_id)
VALUES (true, 100, 1, 150, 2);

-----------------------------------------------------------------------------------------
-- Buy sector

-- Company
INSERT INTO companies(ceo, number_of_employees)
VALUES ( 'Carlos Sainz', 120);

INSERT INTO companies(ceo, number_of_employees)
VALUES ( 'Checo Perez', 90);

-- Seller company.
INSERT INTO seller_companies(
    price_for_transport, company_id)
VALUES (90, 1);

INSERT INTO seller_companies(
    price_for_transport, company_id)
VALUES (100, 2);

-- Building materials
--
 INSERT INTO building_materials(code, height,  length , width, weight, name, product_category, image)
 VALUES ('IS124556', 5.2, 24, 11.5 , 0.3 ,'Medium brick sintered - General Shale' , 14,
         'https://image.made-in-china.com/201f0j00jovuEBkMklcd/Sintered-Clay-Refractory-Fire-Brick-Series-for-Glass-Furnace.webp');
--
 INSERT INTO building_materials(code, height,  length , width, weight, name, product_category, image)
 VALUES ('IS452771', 200, 15, 55 , 55 ,'Enterance door embossed security' , 4,
     'https://sc04.alicdn.com/kf/H6d18f4b3d61c460eab45a81b28a61fdfp.jpg');
--
 INSERT INTO building_materials(code, height,  length , width, weight, name, product_category, image)
 VALUES ('IS421556', 30, 50, 40, 50, 'Cement titan pc 35m', 4, '123');
--
-- -- Material pricelist
 INSERT INTO materilas_pricelists(price, building_material_building_material_id, seller_company_company_id, amount)
 VALUES (0.55, 1, 1, 50000);
--
INSERT INTO materilas_pricelists(price, building_material_building_material_id, seller_company_company_id, amount)
 VALUES (75, 2, 1, 50);
--
 INSERT INTO materilas_pricelists(price, building_material_building_material_id, seller_company_company_id, amount)
 VALUES (11, 3, 1, 1000);
--
 INSERT INTO materilas_pricelists(price, building_material_building_material_id, seller_company_company_id, amount)
 VALUES (12, 3, 2, 910);
--

-- Material orders
--INSERT INTO material_orders(confirmed_date, delivered_date, final_price, ordering_date, rejected_date,
--                          status, trucks_loaded_date, wants_delivery, cooperation_report_cooperation_report_id, material_order_for_building_building_id)
--VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);

-- Material pricelist for orders
--INSERT INTO materilas_pricelists_for_order(materials_price_list_materilas_pricelist_id, for_order_material_order_id)
--VALUES (?, ?);