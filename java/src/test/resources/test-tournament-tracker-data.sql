Insert Into players (user_id, player_name)Values(2, 'Rico Suave');
Insert Into players (user_id, player_name)Values(1, 'Don Julio');
Insert Into players (user_id, player_name)Values(1, 'Jose Cuervo');
Insert Into players (user_id, player_name)Values(1, 'Dom Perignon');
Insert Into players (user_id, player_name)Values(1, 'Jack Daniel');
Insert Into players (user_id, player_name)Values(2, 'Captain Morgan');
Insert Into players (user_id, player_name)Values(1, 'Jim Bean');
Insert Into players (user_id, player_name)Values(1, 'Paul Masson');
Insert Into players (user_id, player_name)Values(1, 'Samuel Adam');
Insert Into players (user_id, player_name)Values(1, 'Shirley Temple');
Insert Into players (user_id, player_name)Values(2, 'Mickey Finn');
Insert Into players (user_id, player_name)Values(1, 'Rob Roy');
Insert Into players (user_id, player_name)Values(1, 'Murray McDavid');
Insert Into players (user_id, player_name)Values(1, 'Tom Collins');
Insert Into players (user_id, player_name)Values(1, 'Stella Artois');

Insert Into teams(team_name, team_size) Values('Oreos', 40);
Insert Into teams(team_name, team_size) Values('Milky Ways', 32);
Insert Into teams(team_name, team_size) Values('Paydays', 25);
Insert Into teams(team_name, team_size) Values('Twinkies', 16);
Insert Into teams(team_name, team_size) Values('Hostess', 40);
Insert Into teams(team_name, team_size) Values('Mounds', 32);
Insert Into teams(team_name, team_size) Values('Baby Ruth', 25);
Insert Into teams(team_name, team_size) Values('Butterfingers', 16);
Insert Into teams(team_name, team_size) Values('Snickers', 40);
Insert Into teams(team_name, team_size) Values('HoHos', 32);
Insert Into teams(team_name, team_size) Values('Zingers', 25);
Insert Into teams(team_name, team_size) Values('Fudge Rounds', 16);
Insert Into teams(team_name, team_size) Values('Three Musketeers', 40);
Insert Into teams(team_name, team_size) Values('Caramellos', 32);
Insert Into teams(team_name, team_size) Values('Take Fives', 25);
Insert Into teams(team_name, team_size) Values('Reeses', 16);

Insert Into sports(sport_name) Values('Softball');

Insert Into tournaments (tournament_name, num_of_teams, start_date, end_date, sport_id, description, num_of_rounds, tournament_type, organizer_id)
Values('Cricket World Cup', 7, '2023-05-08', '2023-05-08', 3, 'cricket', null, null, null);
Insert Into tournaments (tournament_name, num_of_teams, start_date, end_date, sport_id, description, num_of_rounds, tournament_type, organizer_id)
Values('Las Vegas Table Tennis', 6, '2023-07-08', '2023-07-08', 4, 'ping pong', null, null, null);
Insert Into tournaments (tournament_name, num_of_teams, start_date, end_date, sport_id, description, num_of_rounds, tournament_type, organizer_id)
Values('World Cup', 7, '2022-06-08', '202-06-13', 5, 'soccer', null, null, null);
Insert Into tournaments (tournament_name, num_of_teams, start_date, end_date, sport_id, description, num_of_rounds, tournament_type, organizer_id)
Values('All Star Race', ,'2022-05-23', '2022-05-23', 6, 'nascar', null, null, null);
Insert Into tournaments (tournament_name, num_of_teams, start_date, end_date, sport_id, description, num_of_rounds, tournament_type, organizer_id)
Values('USA RPS', 6, '2023-07-08', '2023-07-08', 7, 'rock paper scissors', null, null, null);
Insert Into tournaments (tournament_name, num_of_teams, start_date, end_date, sport_id, description, num_of_rounds, tournament_type, organizer_id)
Values('Arnold Classic Arm Wrestling', 7, '2023-03-13', '2023-03-13', 8, 'arm wrestling', null, null, null);
Insert Into tournaments (tournament_name, num_of_teams, start_date, end_date, sport_id, description, num_of_rounds, tournament_type, organizer_id)
Values('Little League Baseball World Series', 6, '2022-11-13', '2022-11-18', 10, 'baseball', null, null, null);
Insert Into tournaments (tournament_name, num_of_teams, start_date, end_date, sport_id, description, num_of_rounds, tournament_type, organizer_id)
Values('Us Open', 7, '2023-03-13', '2023-03-16', 11, 'golf', null, null, null);
Insert Into tournaments (tournament_name, num_of_teams, start_date, end_date, sport_id, description, num_of_rounds, tournament_type, organizer_id)
Values('Frozen Four', 6, '2023-04-13', '2023-04-20', 12, 'hockey', null, null, null);
Insert Into tournaments (tournament_name, num_of_teams, start_date, end_date, sport_id, description, num_of_rounds, tournament_type, organizer_id)
Values('Spring Poker Classic', 7, '2022-05-23', '2022-05-23', 13, 'poker', null, null, null);
Insert Into tournaments (tournament_name, num_of_teams, start_date, end_date, sport_id, description, num_of_rounds, tournament_type, organizer_id)
Values('Wimbledon', 6, '2022-06-27', '2022-07-10', 14, 'tennis', null, null, null);
Insert Into tournaments (tournament_name, num_of_teams, start_date, end_date, sport_id, description, num_of_rounds, tournament_type, organizer_id)
Values('Womens College World Series', 6, '2023-06-03', '2023-06-09', 15, 'softball', null, null, null);

Insert Into tournament_teams(team_id, tournament_id) Values(1, 1);
Insert Into tournament_teams(team_id, tournament_id) Values(2, 2);
Insert Into tournament_teams(team_id, tournament_id) Values(3, 3);
Insert Into tournament_teams(team_id, tournament_id) Values(6, 6);
Insert Into tournament_teams(team_id, tournament_id) Values(7, 7);
Insert Into tournament_teams(team_id, tournament_id) Values(8, 8);
Insert Into tournament_teams(team_id, tournament_id) Values(9, 9);
Insert Into tournament_teams(team_id, tournament_id) Values(10, 10);
Insert Into tournament_teams(team_id, tournament_id) Values(11, 11);
Insert Into tournament_teams(team_id, tournament_id) Values(12, 12);
Insert Into tournament_teams(team_id, tournament_id) Values(13, 13);
Insert Into tournament_teams(team_id, tournament_id) Values(14, 14);
Insert Into tournament_teams(team_id, tournament_id) Values(15, 15);

Insert Into matches(tournament_id, start_date, start_time, home_team_id, location_id, winning_team_id, round_number)
Values(1, '2022-3-1', '08:00', 1, 1, 2, 1);
Insert Into matches(tournament_id, start_date, start_time, home_team_id, location_id, winning_team_id, round_number)
Values(2, '2022-11-11', '07:00', 2, 3, 4, 2);
Insert Into matches(tournament_id, start_date, start_time, home_team_id, location_id, winning_team_id, round_number)
Values(3, '2024-05-08', '09:00', 3, 5, 6, 3);