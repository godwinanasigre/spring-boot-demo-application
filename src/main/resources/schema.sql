CREATE TABLE station (
    stationId VARCHAR PRIMARY KEY,
    name VARCHAR,
    hdEnabled BOOLEAN,
    callSign VARCHAR
);

CREATE INDEX stationName ON station(name);
CREATE INDEX stationHdEnabled ON station(hdEnabled);