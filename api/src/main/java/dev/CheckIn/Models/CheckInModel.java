package dev.CheckIn.Models;

import lombok.Data;

@Data
public class CheckInModel {
    String Longitude;
    String Latitude;
    long IdUser;
    int Note;
}
