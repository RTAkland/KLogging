/*
 * Copyright © 2025 RTAkland
 * Date: 2025/5/7 00:34
 * Open Source Under Apache-2.0 License
 * https://www.apache.org/licenses/LICENSE-2.0
 */

package cn.rtast.klogging.filesystem

import kotlinx.io.files.Path

public actual class File {
    internal val path: Path

    public actual constructor(path: String) {
        this.path = Path(path)
    }
}