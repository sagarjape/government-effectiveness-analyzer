Create table worlddata( year integer, country varchar(100), voice_accountability float, politicalstability_voilence float, governmenteffectiveness float, regulatory_quality float, rule_of_law float, controlofcurroption float)
select * from worlddata
copy worlddata(year, country, voice_accountability, politicalstability_voilence, governmenteffectiveness,regulatory_quality, rule_of_law, controlofcurroption) from 'C:\worlddata.csv' using DELIMITERS ',' csv header encoding 'windows-1251';
drop table worlddata
