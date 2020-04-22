create database stockdb default character set utf8 collate utf8_general_ci;

CREATE TABLE Stock2 (
	stockCode VARCHAR ( 255 ) ,
	stockName VARCHAR ( 255 ),
	rise VARCHAR ( 255 ),
	marketId VARCHAR ( 255 ),
	price VARCHAR ( 255 ),
	priceRise VARCHAR ( 255 ),
	inflow VARCHAR ( 255 ),
	inflowOrigin VARCHAR ( 255 ),
	shareHolding VARCHAR ( 255 ),
	shareHoldingOrigin DOUBLE,
	radio VARCHAR ( 255 )
);

CREATE TABLE Stock (
	DateType VARCHAR ( 255 ),
	HdDate Date,
	Hkcode VARCHAR ( 255 ),
	SCode VARCHAR ( 255 ),
	SName VARCHAR ( 255 ),
	HYName VARCHAR ( 255 ),
	HYCode VARCHAR ( 255 ),
	ORIGINALCODE VARCHAR ( 255 ),
	DQName VARCHAR ( 255 ),
	DQCode VARCHAR ( 255 ),
	ORIGINALCODE_DQ VARCHAR ( 255 ),
	JG_SUM INT,
	SharesRate DOUBLE,
	NewPrice DOUBLE,
	Zdf DOUBLE,
	Market VARCHAR ( 255 ),
	ShareHold BIGINT,
	ShareSZ DOUBLE,
	LTZB DOUBLE,
	ZZB DOUBLE,
	LTSZ DOUBLE,
	ZSZ DOUBLE,
	ShareHold_Before_One INT,
	ShareSZ_Before_One INT,
	ShareHold_Chg_One BIGINT,
	ShareSZ_Chg_One DOUBLE,
	ShareSZ_Chg_Rate_One DOUBLE,
	LTZB_One DOUBLE,
	ZZB_One DOUBLE
)