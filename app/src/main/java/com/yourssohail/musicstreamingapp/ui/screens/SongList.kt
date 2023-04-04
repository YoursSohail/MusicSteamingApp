import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yourssohail.musicstreamingapp.data.Song
import com.yourssohail.musicstreamingapp.data.songsList
import com.yourssohail.musicstreamingapp.ui.helper.SongHelper

@Composable
fun SongsList(songsList: List<Song>, onSongSelected: (song: Song) -> Unit) {
    var isSongSelected by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = if (isSongSelected) {
                    48.dp
                } else {
                    4.dp
                }
            )
    ) {
        items(songsList) { song ->
            SongCard(song = song, onClick = {
                isSongSelected = true
                SongHelper.stopStream()
                onSongSelected(song)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SongsListPreview() {
    SongsList(
        songsList = songsList,
        onSongSelected = {}
    )
}
