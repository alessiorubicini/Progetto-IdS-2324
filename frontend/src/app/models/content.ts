import { ContentStatus } from "./contentstatus";
import { Media } from "./media";
import { Point } from "./point";
import { User } from "./user";

export interface Content {
	id: number;
	title: string;
	description: string;
	publicationDate: Date;
	status: ContentStatus;
	author: User;
	point: Point;
	media: Media;
}