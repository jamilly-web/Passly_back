package dev.CheckIn.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.Duration;
import java.time.LocalDateTime;

import dev.Client.Entity.TuristaEntity;

@Data
public class CheckInModel {
    private String Latitude;
    private  String Longitude;
    private short Nota;
    private  String Comentario;
}