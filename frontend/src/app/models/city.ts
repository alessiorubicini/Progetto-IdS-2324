import { Point } from "./point";

export interface City {
	id: number;
	cadastralCode: string;
	name: string;
	region: string;
	istatCode: string;
	points: Point[];
}